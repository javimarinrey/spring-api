pipeline {
    agent any

    environment {
        SPRING_PROFILES_ACTIVE = 'prod'
        JAR_NAME = 'app.jar'
        DEPLOY_USER = 'usuario'
        DEPLOY_HOST = 'servidor-prod.com'
        DEPLOY_PATH = '/ruta/a/tu/app'
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/tuusuario/tu-repo.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Deploy to Production') {
            steps {
                sh """
                scp target/${JAR_NAME} ${DEPLOY_USER}@${DEPLOY_HOST}:${DEPLOY_PATH}
                """

                sh """
                ssh ${DEPLOY_USER}@${DEPLOY_HOST} '
                    pkill -f ${JAR_NAME} || true
                    nohup java -jar ${DEPLOY_PATH}/${JAR_NAME} --spring.profiles.active=prod > ${DEPLOY_PATH}/app.log 2>&1 &
                '
                """
            }
        }
    }

    post {
        success {
            echo '🚀 Despliegue completado exitosamente en producción'
        }
        failure {
            echo '💥 Falló el despliegue'
        }
    }
}
