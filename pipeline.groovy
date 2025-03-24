pipeline {
    agent any
    parameters {
        string(name: 'VERSION', defaultValue: '1.0', description: 'Version number to deploy')
        choice(name: 'ENVIRONMENT', choices: ['dev', 'qa', 'prod'], description: 'Target environment')
        booleanParam(name: 'DRY_RUN', defaultValue: true, description: 'Test run without deployment')
    }
    stages {
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
}