#!groovy

pipeline {
    agent any
    environment {
        registry = "kostiakorzh/demoshop-user-service"
        registryCredential = 'dockerhub'
        dockerImage = ''
    }
    stages {
        stage('Build') {
            steps {
                script {
                    dockerImage = docker.build registry
                }
            }
        }
        stage('Push to dockerhub') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push("latest")
                    }
                }
            }
        }
        stage("Deploy to docker") {
            steps {
                sh 'docker rm -f user-dev-container'
                sh 'docker rmi kostiakorzh/demoshop-user-service-dev'
                sh 'docker run -p 8082:8082 -d --name user-dev-container -e MYSQL_URL=jdbc:mysql://demo-shop.c9pmrkdcjaav.eu-central-1.rds.amazonaws.com/users_db -e MYSQL_ROOT_PASSWORD=root1234  kostiakorzh/demoshop-user-service-dev'
            }
        }
    }
}