# Deployment and Release Process for Kaizen SDK

## Prerequisites

Before you can build and deploy the KaizenSDK, make sure you have the following tools installed:

- [Android Studio 4.0.0+](https://developer.android.com/studio)
- **Android API 16+**
- [Kotlin 1.4+](https://kotlinlang.org/)

Make sure to have these prerequisites installed and configured properly before proceeding with the SDK deployment process.

## Build SDK

To build Kaizen SDK, follow these steps:

1. Clone the [Kaizen SDK git repository](https://gitlab.com/prettytechnical/kaizen/android-sdk). Note that this is a private repository and you will need access to it.
2. Run the ``./gradlew clean build`` command, which will build the SDK aar file.
3. If the command succeeds, This will generate the ``.aar`` file in the ``kaizen/build/outputs/aar directory``. Copy this file to the deployment repository at [Kaizen Deployment Repo](https://github.com/danielcPrettytechnical/Kaizen-Android-SDK) and push it.

## Tag Release

To tag a new release of Kaizen SDK, follow these steps:

1. Update the podspec file with the new version number.
2. Push the changes to the git repository at [Kaizen Deployment Repo](https://github.com/danielcPrettytechnical/Kaizen-Android-SDK)
3. Create a tag using [semantic versioning](https://semver.org/).
4. Push the tag to the git repository. Note that this is important so that there can be an order of versioning.
5. Publish the SDK by updating the repository to point to the new tag. The SDK can be installed by downloading file from the repo and using Gradle with the following line: 

`` implementation files('libs/KaizenSDK.aar')``

## Additional Information
All development of Kaizen SDK are deployed to the following repository URL: [Kaizen SDK git repository](https://gitlab.com/prettytechnical/kaizen/android-sdk)
The aar file is pushed to the deployment repository at [Kaizen Deployment Repo](https://github.com/danielcPrettytechnical/Kaizen-Android-SDK), and Gradle is used as the dependency manager to install the SDK.
