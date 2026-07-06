pipeline {

    agent any

    tools {
        maven 'Maven3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/someswar01/RestAPIFramework1_TestNG.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }

         stage('Publish Allure Report') {
                    steps {
                        allure([
                            includeProperties: false,
                            jdk: '',
                            results: [[path: 'target/allure-results']]
                        ])
                    }
        }
    }

   post {

           always {
               archiveArtifacts artifacts: 'allure-results/**', fingerprint: true
           }

           success {
               echo 'Framework execution completed successfully'
           }

           failure {
               echo 'framework execution failed'
           }
   }
}