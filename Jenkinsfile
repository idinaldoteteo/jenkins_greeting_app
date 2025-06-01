pipeline {
    agent any
    tools{
        maven "mvn"
    }
    environment {
        DOCKERHUB = credentials("dockerHub")
    }
    stages {
        stage('Checkout') {
            steps {
                git(url:'https://github.com/idinaldoteteo/jenkins_greeting_app.git', branch: 'main')
            }
        }
        stage('Build') {
            steps {
                bat 'mvn -DskipTests clean package'
            }
        }
        stage('Tests') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Docker creat image'){
            steps {
                bat "docker build . -t teteo/greeting_app:TAG_VERSION"
                bat "docker tag teteo/greeting_app:TAG_VERSION teteo/greeting_app:latest"
            }
        }
        stage("Docker push image"){
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerHub', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]){
                    bat "docker login --username=$DOCKERHUB_USR --password=$DOCKERHUB_PSW"
                    bat "docker push teteo/greeting_app:TAG_VERSION"
                    bat "docker push teteo/greeting_app:latest"
                }
            }
        }
    }
}
