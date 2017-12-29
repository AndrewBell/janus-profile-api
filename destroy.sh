#!/bin/bash
#
# Destroys the remote project in GKE
#
# `sh ./destroy app-name`
#

err() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $@" >&2
}

# Get deployment parameters and build a tag

app_name='';

if [ -z "$1" ]; then
  err "Please pass a app name."
  exit 1
fi

app_name=$1

if ! kubectl delete service $app_name ; then
fi

