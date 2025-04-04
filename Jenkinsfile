pipeline {
    agent any
    environment {
        // Defining AWS registry credentials and repository
        AWS_ACCESS_KEY_ID = credentials('aws-access-key-id')
        AWS_SECRET_ACCESS_KEY = credentials('aws-secret-access-key')
        AWS_DEFAULT_REGION = 'us-east-1'  // Specify the AWS region
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
                docker.compose(composeFile: 'docker-compose.yaml').build('--no-cache')
            }
        }
        stage('test') {
            steps {
                echo 'Testing the Application'
            }
        }
        stage('deploy to AWS ECR') {
            steps {
                docker.image("530789571735.dkr.ecr.us-east-1.amazonaws.com/ng-frontend:react_frontend").push()
                docker.image("530789571735.dkr.ecr.us-east-1.amazonaws.com/ng-backend:spring_api").push()
                docker.image("530789571735.dkr.ecr.us-east-1.amazonaws.com/ng-backend:mysql").push() 
            }
        }
    }
}