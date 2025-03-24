pipeline {
    agent any

    // Define parameters
    parameters {
        string(name: 'VERSION', defaultValue: '1.0', description: 'Version number to deploy')
        choice(name: 'ENVIRONMENT', choices: ['dev', 'qa', 'prod'], description: 'Target environment')
        booleanParam(name: 'DRY_RUN', defaultValue: true, description: 'Test run without deployment')
    }

    // Configure SCM (Git repository)
    options {
        gitConnectionTimeout(60) // Timeout for Git operations
    }

    triggers {
        pollSCM('H/5 * * * *') // Poll SCM every 5 minutes (optional)
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']], // Replace 'main' with your branch name
                    userRemoteConfigs: [[
                        url: 'https://github.com/your-repo/your-project.git', // Replace with your repo URL
                        credentialsId: 'your-credentials-id' // Replace with your Jenkins credentials ID
                    ]]
                ])
                echo "Checked out code from branch: main"
            }
        }

        stage('Setup') {
            steps {
                echo "Selected Version: ${params.VERSION}"
                echo "Target Environment: ${params.ENVIRONMENT}"
            }
        }

        stage('Deploy') {
            steps {
                script {
                    if (params.DRY_RUN) {
                        echo "Dry run enabled. Skipping deployment."
                    } else {
                        echo "Deploying to ${params.ENVIRONMENT}..."
                        // Add deployment commands here
                    }
                }
            }
        }
    }

    post {
        success {
            echo "Pipeline succeeded!"
        }
        failure {
            echo "Pipeline failed!"
        }
    }
}
