#!/usr/bin/env bash

psql -h db -U postgres -c "CREATE DATABASE ${DATABASE_NAME};"