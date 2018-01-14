#!/bin/bash
#
# Deploys a database to spanner
#
# `sh ./deploy project-name`
#

log() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $@" >&2
}

# Get deployment parameters

project_name='';

if [ -z "$1" ]; then
  log "Please pass a project name."
  exit 1
fi

project_name=$1

instance_name=$project_name-instance
database_name=$project_name-db

# Create resources

echo "Creating Instance $instance_name..."

if ! gcloud spanner instances create $instance_name --config=regional-us-central1 --description="Profile API Database" --nodes=1 ; then
  log "Could not create Spanner instance"
  exit 1
fi

echo "Creating a $database_name..."

if ! gcloud spanner databases create $database_name --instance=$instance_name ; then
  log "Could not build Docker image"
  exit 1
fi

echo "Confirming your order..."

if ! gcloud spanner databases list --instance=$instance_name ; then
  log "Could not push Docker image to container registry."
  exit 1
fi

echo "Database $database_name created!"