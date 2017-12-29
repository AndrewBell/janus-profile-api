#!/bin/bash
#
# Deploys local project to GKE
#
# `sh ./deploy project-name`
#

err() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $@" >&2
}

# Get deployment parameters and build a tag

app_name='';
project_id='';

if [ -z "$1" ]; then
  err "Please pass a app name."
  exit 1
fi

app_name=$1

if [ -z $GCP_PROJECT_ID ]; then
  err "Please 'export GCP_PROJECT_ID=your_google_cloud_project_unique_id'"
  exit 1
fi

project_id=$GCP_PROJECT_ID

tag=us.gcr.io/$project_id/$app_name
version=1.0

echo "Deploying $app_name to to $tag:$version"

# Deploy artifact

echo "Fattening jars..."

if ! ./gradlew clean build ; then
  err "Could not build Gradle artifact"
  exit 1
fi

echo "Packing containers..."

if ! docker build . --tag $tag:$version ; then
  err "Could not build Docker image"
  exit 1
fi

echo "Pushing it to the limit..."

if ! gcloud docker -- push $tag:$version ; then
  err "Could not push Docker image to container registry."
  exit 1
fi

echo "Current images:"

gcloud container images list-tags $tag

# Run app

if ! kubectl run $app_name --image=$tag:$version --port 8080 ; then
  err "Could not launch app. (Maybe you haven't set up the cluster yet?)"
  exit 1
fi

if ! kubectl expose deployment $app_name --type="LoadBalancer" ; then
  err "Could not expose app."
  exit 1
fi

kubectl get service $app_name

echo "Fetching IP. Run 'kubectl get service $app_name' to check again."