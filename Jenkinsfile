pipeline {
    agent any
    environment {

    }
    stages{
        stage('build') {
            steps {
                checkout scm
                sh '''
                    echo "Building Application Stage"
                    echo "Building Docker Image Files"
                    docker compose build
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
                withCredentials([aws(accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: )])
            }
        }
    }


}