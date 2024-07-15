#!/bin/bash

# Exit immediately if a command exits with a non-zero status
set -e

# Define SonarQube project details
SONAR_PROJECT_KEY="demo2"
SONAR_PROJECT_NAME="demo2"
SONAR_HOST_URL="http://localhost:9000"
SONAR_TOKEN="sqp_b780b09ceab26ffb5e28c2b760ad0f4ba7a94740"

# Check if SONAR_HOST_URL and SONAR_TOKEN are set
if [ -z "$SONAR_HOST_URL" ] || [ -z "$SONAR_TOKEN" ]; then
  echo "Error: SONAR_HOST_URL and SONAR_TOKEN environment variables must be set."
  exit 1
fi

# Run Maven clean, verify, and SonarQube analysis
echo "Running 'mvn clean verify sonar:sonar'..."
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=$SONAR_PROJECT_KEY \
  -Dsonar.projectName="$SONAR_PROJECT_NAME" \
  -Dsonar.host.url=$SONAR_HOST_URL \
  -Dsonar.login=$SONAR_TOKEN

echo "SonarQube analysis completed."
