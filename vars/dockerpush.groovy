
def call(credentialsId, image, tag) {

    withCredentials([
        usernamePassword(
            credentialsId: credentialsId,
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )
    ]) {

        sh """
            echo \$dockerHubPass | docker login -u \$dockerHubUser --password-stdin
            docker tag ${image}:${tag} yash93344/${image}:${tag}
            docker push yash93344/${image}:${tag}
        """
    }
}
