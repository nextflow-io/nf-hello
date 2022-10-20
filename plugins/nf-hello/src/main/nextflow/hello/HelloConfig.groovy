package nextflow.hello

import groovy.transform.PackageScope


/**
 * @author : jorge <jorge.aguilera@seqera.io>
 *
 */
@PackageScope
class HelloConfig {

    String prefix

    HelloConfig(Map map){
        def config = map ?: Collections.emptyMap()
        prefix = config.prefix ?: 'Mr.'
    }

}
