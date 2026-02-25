
pipeline {
  agent any

  tools {
      jdk 'JDK 17'
      maven 'Maven3'
  }

  environment {
      PATH = "C:\\Program Files\\Docker\\Docker\\resources\\bin;${env.PATH}"
      DOCKERHUB_CREDENTIALS_ID = 'docker_hub'
      DOCKERHUB_REPO = 'laughingcryingfaceemoji/speedcalc'
      DOCKER_IMAGE_TAG = 'latest'
  }

  stages {

      stage('Checkout') {
          steps {
              git branch: 'main',
                url: 'https://github.com/laughingcryingfaceemoji/speedcalc'
          }
      }

      stage('Run Tests') {
          steps {
              bat 'mvn clean test'
          }
      }

      stage('Code Coverage') {
          steps {
              bat 'mvn jacoco:report'
          }
      }

      stage('Publish Test Results') {
          steps {
              junit '**/target/surefire-reports/*.xml'
          }
      }



      stage('Build Docker Image') {
          steps {
              script {
                  docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
              }
          }
      }

      stage('Push Docker Image to Docker Hub') {
          steps {
              script {
                  docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                      docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                  }
              }
          }
      }

  }
}
