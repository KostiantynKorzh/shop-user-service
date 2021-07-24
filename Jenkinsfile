#!groovy

pipeline {
    agent any
    environment {
        registry = "kostiakorzh/demoshop-user-service"
        registryCredential = 'Dockerhub'
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
        stage("Deploy to k8s") {
            steps {
                sh 'sudo kubectl rollout restart deployment/user-deployment'
            }
        }
    }
}