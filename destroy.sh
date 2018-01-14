#!/bin/bash
#
# Destroys the remote project in GKE
#
# `sh ./destroy app-name`
#

log() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $@" >&2
}

# Get deployment parameters and build a tag

app_name='';

if [ -z "$1" ]; then
  log "Please pass a app name."
  exit 1
fi

app_name=$1

if ! kubectl delete service $app_name ; then
  log "Could not delete service $app_name. You should run `kubectl delete service $app_name` and troubleshoot"
  exit 1
fi

echo "All cleaned up"
