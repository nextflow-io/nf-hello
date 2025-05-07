
include { goodbye ; randomString ; reverse } from 'plugin/nf-hello'

workflow {
    Channel
        .reverse( randomString(20) )
        .goodbye()
        .view()
}
