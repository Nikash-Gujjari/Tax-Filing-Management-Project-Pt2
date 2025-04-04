pipeline {
    agent any
    // environment {

    // }
    stages{
        stage('build') {
            steps {
                // checkout scm
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