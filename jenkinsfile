pipeline {
    agent any
    tools{
        maven 'maven_3_9_0'
    }
    stages {
        stage('Build') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/neeleshdubey567/devops-automation']])
                bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t neeleshdubey/devops-integration .'
                }
            }
        }
        stage('login to dockerhub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'DOCKERHUBPWD')]) {
                    bat 'docker login -u neeleshdubey -p %DOCKERHUBPWD%'
}
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                bat 'docker push neeleshdubey/devops-integration:latest'
            }
        }
    }
}