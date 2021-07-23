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
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }
        stage('Push to dockerhub') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
        stage("Deploy to k8s") {
            steps {
                script {
                    echo dockerImage
                    kubectl set image deployment/jenkins dockerImage --record
                }
            }
        }
    }
}