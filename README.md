# nf-hello plugin

This project contains a simple Nextflow plugin called `nf-hello` which provides examples of different plugin extensions:

- A custom trace observer that prints a message when the workflow starts and when the workflow completes
- A custom channel factory called `reverse`
- A custom operator called `goodbye`
- A custom function called `randomString`

NOTE: If you want to use this project as a starting point for a custom plugin, you must rename the `plugins/nf-hello`
folder and update `settings.gradle` with your plugin name.

See the [Nextflow documentation](https://nextflow.io/docs/latest/plugins.html) for more information about developing
plugins.

## Plugin structure

- `settings.gradle`

  Gradle project settings.

- `src/main`

  The plugin implementation sources.

- `src/test`

  The plugin unit tests.

## Plugin classes

- `HelloConfig`: shows how to handle options from the Nextflow configuration

- `HelloExtension`: shows how to create custom channel factories, operators, and fuctions that can be included into
  pipeline scripts

- `HelloFactory` and `HelloObserver`: shows how to react to workflow events with custom behavior

- `HelloPlugin`: the plugin entry point

## Building

To compile and assemble the plugin, run the following command in the project root directory:
```bash
make assemble
```

## Unit testing

To run your unit tests, run the following command in the project root directory:
```bash
make test
```

## Testing with Nextflow

The plugin can be tested without a local Nextflow installation:

1. Build and install the plugin to your local Nextflow installation: `make install`
2. Create a pipeline that uses your plugin and run it: `nextflow run ./my-pipeline-script.nf`

## Package, upload, and publish

Follow these steps to package, upload and publish the plugin:

1. In `build.gradle` make sure that
    * `github.repository` matches the repository of the plugin
    * `github.indexUrl` points to your fork of the plugins index repository.

2. Create a file named `$HOME/.gradle/gradle.properties`, where $HOME is your home directory. Add the following properties:

    * `github_username`: The GitHub username granting access to the plugin repository.
    * `github_access_token`: The GitHub access token required to upload and commit changes to the plugin repository.
    * `github_commit_email`: The email address associated with your GitHub account.

3. Use the following command to package and create a release for your plugin on GitHub: `make release`

4. Create a pull request against [nextflow-io/plugins](https://github.com/nextflow-io/plugins/blob/main/plugins.json) to
   make the plugin accessible to Nextflow.
