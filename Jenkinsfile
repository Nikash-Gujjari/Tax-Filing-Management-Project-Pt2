pipeline {
    agent any
    environment {
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
                sh '''
                    docker compose build
                '''
            }
        }
        stage('test') {
            steps {
                echo 'Testing the Application'
            }
        }
        stage('deploy to AWS ECR') {
            steps {
                withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', credentialsId: 'aws-credentials-id']]) {
                    sh '''
                        docker push 530789571735.dkr.ecr.us-east-1.amazonaws.com/ng-frontend:react_frontend
                        docker push 530789571735.dkr.ecr.us-east-1.amazonaws.com/ng-backend:spring_api
                        docker push 530789571735.dkr.ecr.us-east-1.amazonaws.com/ng-backend:mysql
                    '''
                }
            }
        }
    }
}