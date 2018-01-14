#!/bin/bash
#
# Destroys the remote Spanner db
#
# `sh ./destroy app-name`
#

log() {
  echo "[$(date +'%Y-%m-%dT%H:%M:%S%z')]: $@" >&2
}

# Get deployment parameters and build a tag

project_name='';

if [ -z "$1" ]; then
  log "Please pass a project name."
  exit 1
fi

project_name=$1

log "Deleting $project_name-instance..."

if ! gcloud spanner instances delete $project_name-instance --quiet; then
  log "Could not destroy $project_name-instance. You should run `gcloud spanner instances delete $project_name-instance` and troubleshoot."
  exit 1
fi

log "$project_name-instance deleted"