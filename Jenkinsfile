// TODO: fix this pipeline
pipeline {
    agent any

    stages {
        stage('Deploy to QA') {
            steps {
                script {
                    sh 'SPRING_PROFILES_ACTIVE=prod docker-compose up -d'
                }
            }
        }

        stage('Deploy to Production') {
            steps {
                script {
                    // Login to Azure
                    sh 'az login --service-principal --username <app-id> --password <password> --tenant <tenant-id>'

                    // Create a resource group
                    sh 'az group create --name myResourceGroup --location eastus'

                    // Create a Postgres server
                    sh 'az postgres server create --name myServer --resource-group myResourceGroup --location eastus --admin-user myAdmin --admin-password <admin-password> --sku-name B_Gen5_1'

                    // Configure firewall
                    sh 'az postgres server firewall-rule create --resource-group myResourceGroup --server myServer --name AllowAllAzureIps --start-ip-address 0.0.0.0 --end-ip-address 0.0.0.0'

                    // Deploy to Azure Container Instances
                    sh 'az container create --resource-group myResourceGroup --name myContainer --image rodrigorvsn/ac2:latest --dns-name-label ac2-app --ports 9090 --environment-variables SPRING_PROFILES_ACTIVE=prod'
                }
            }
        }
    }
}