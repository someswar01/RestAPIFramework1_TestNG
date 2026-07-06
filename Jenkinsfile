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

        stage('Generate Allure Report') {
            steps {
                allure([
                        includeProperties: false,
                        jdk: '',
                        results: [[path: 'allure-results']]
                ])
            }
        }
    }

    post {

        always {

            archiveArtifacts artifacts: 'test-output/**/*',
                             fingerprint: true

            archiveArtifacts artifacts: 'ExtentReports/**/*',
                             fingerprint: true
        }

        success {
            echo 'Framework executed successfully.'
        }

        failure {
            echo 'Framework execution failed.'
        }
    }
}