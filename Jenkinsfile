pipeline {
    agent any
    environment {
        // Define Docker registry credentials and repository
        DOCKER_REGISTRY = "your-docker-registry-url"
        DOCKER_IMAGE = "your-image-name"
        DOCKER_TAG = "latest"  // You can use a dynamic tag like commit hash or branch name
    }
    stages {
        stage('Checkout Code') {
            steps {
                // Checkout the code from my Git repository
                checkout scm
            }
        }
        stage('build') {
            steps {
                sh '''
                    echo "Building Application Stage"
                    echo "Building Database Docker Image"
                    docker compose build db
                    echo "Building Spring API Docker Image"
                    docker compose build spring-api-backend
                    docker compose build spring-api-backend
                    echo "Building React Frontend Docker Image"
                    docker compose build react-frontend
                '''
            }
        }
        stage('test') {
            steps {
                echo 'Testing the Application'
            }
        }
        stage('deploy') {
            steps {
                echo 'Deploying the Application'
                // withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: )])
            }
        }
    }
}