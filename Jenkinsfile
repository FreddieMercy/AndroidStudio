CODE_CHANGE = getGitChanges()

pipeline {
    agent any // any agent... but what is 'agent'?

    stages {
        stage('Build') {
            steps {
                echo 'Building succeed ... hello from Freddie'
                echo CODE_CHANGE
            }
        }
        stage('Test') {
            when {
                // run echo 'Testing succeed as well ... nihao from Freddie'
                // only when it is on the master branch
                expression {
                    BRANCH_NAME == 'master' // || BRANCH_NAME == 'dev'
                }
            }
            steps {
                echo 'Testing succeed as well ... nihao from Freddie'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying done .... say bye to Freddie '
            }
        }
    }

    post{
        // Conditions:
        //  * always
        //  * success
        //  * failure
        // always{
        //     // 
        // }

        // success{

        // }
    }
}