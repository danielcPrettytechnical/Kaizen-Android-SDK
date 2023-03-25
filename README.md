# Kaizen SDK
Kaizen is a power component development kit made with love from the pretty technical team for the Kaizen project.

Check deployment and release process [**Deployment and Release**](https://github.com/danielcPrettytechnical/Kaizen-Android-SDK/blob/main/Deployment.md)

# Requirements

 -   Android Studio 4.0.0+
 -   Android API 16+
 -   Kotlin 1.4+

# Config project

 Just clone the project to your local folder, open the build.gradle file and you'r ready to go.

# Git
To accomplish pretty technical standards we use git flow to manage the code, please see our guidelines from our [confluence](https://prettytechnical.atlassian.net/wiki/spaces/PT/pages/304054462/Development+Git+guidelines) page 

This is our git DOD rules to release and finish features.

![enter image description here](https://firebasestorage.googleapis.com/v0/b/mikadosdk.appspot.com/o/git_deployments_rule.jpg?alt=media&token=f60b904e-fa09-43d1-a358-0bb1df22c5cb)

# Architecture

To accomplish each feature as a DOD we have to deliver each block of code by using this architecture below. 

![Project SDK architecture overview](https://firebasestorage.googleapis.com/v0/b/mikadosdk.appspot.com/o/Architecture.jpg?alt=media&token=235cb8a2-a429-42ff-a308-b2a120e3cd62)

## Core

Core is the orquesta layer of our main architecture. Is responsible and it also provide base code for each layer.
**The core layer is usually static and we can't add or create new files without the confirmation of the tech manager**

## Managers
Managers are responsible of any helper class that can be provided by each layer. For example a logger or a framework that can improve the work.

Always think that this is a class that all the three layers need. 

## Data
Contains _Repository Implementations and one or many Providers Sources_. ​ **Repositories** are responsible for coordinating data from different API or database. **Providers** consume the repositories and map the data information to **Domain** layer. Data Layer depends only on the Domain Layer. 

Data connects with Domain layer with providers. First we have to declare a [**ProviderContract**](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/master/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/domain/providersContract/TemplateProviderContract.kt) in the domain layer and then add the logic code in the [**Provider Data class**](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/feature/KVS-11_Define_Android_data_domain_and_presentation_layer_template/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/data/providers/templateProvider/TemplateProvider.kt)
 
 **You can check the template class code in the Git repository, please kindly use the template. If not, it can affect the DOD guidelines and the merge request can be rejected.**

## Domain
Is the innermost part of the onion (without dependencies to other layers, it is totally isolated). It contains [**Entities**](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/master/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/domain/entities/TemplateEntity.kt)(Business Models) and **[ProvidersContract](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/feature/KVS-11_Define_Android_data_domain_and_presentation_layer_template/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/domain/providersContract/TemplateProviderContract.kt)** Interfaces. This layer could be potentially reused within different projects. Such separation give the benefit of making the test target independet from the host app, because no dependencies (also 3rd party) are needed — this makes the Domain Use Cases tests take just a few seconds. Note: Domain Layer should not include anything from other layers(e.g Data, Presentation, UI, UX).

Each [**Entities**](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/master/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/domain/entities/TemplateEntity.kt) it must inherited from `BaseEntity` and is important to use the `toPresentation()`  method to map the business model to presentation.

To connect the domain logic to the presentation layer we use **[UseCases](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/master/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/domain/usecase/templateUseCase/TemplateUseCase.kt)**. Is important to use the use case template to call the data provider contract, map entity to presentation model and send it.

**You can check the template class code in the Git repository, please kindly use the template. If not, it can affect the DOD guidelines and the merge request can be rejected.**

## Presentation
It contains _UI (Activities and Fragments). Views_ are coordinated by _ViewModels (Presenters) which execute one or many Use Cases._ Presentation Layer **depends only** on the **Domain Layer**.

We use LiveData and we manage different stages with a view state **[observable](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/master/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/presentation/scenes/templateScene/viewModel/TemplateViewModel.kt)**

The **[fragment](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/master/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/presentation/scenes/templateScene/view/TemplateFragment.kt)** reference the **[view model contract](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/master/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/presentation/scenes/templateScene/viewModel/TemplateViewModel.kt)** to manage all the presentation logic inside the view model. The **[view state](https://gitlab.com/prettytechnical/kaizen/android-sdk/-/blob/master/Kaizen%20SDK/src/main/java/com/prettytechnical/kaizen_sdk/presentation/scenes/templateScene/view/TemplateFragment.kt)** will notify the fragment when logic has change.

**You can check the template class code in the Git repository, please kindly use the template. If not, it can affect the DOD guidelines and the merge request can be rejected.**

## Rules DOD
To accomplish a feature we have to:

 1. Cover all the code coverage with unit test.
 2. Accomplish the architecture rules.
 3. At least one approval for the mobile architecture team.

## Help
If you have any doubts during the development cycle related to the architecture, code styling or any other subject please don't hesitate to ask. It is preferible to solve questions when arising that on Pull Request when everything is done. It is quicker, less frustrating and results on better code.

You can ask your colleagues, your Product Owner or the  [Mobile Chapter Lead](gumersindoa@prettytechnical.io). We will try to attend your request as soon as possible.

**We also ask for your help! Help us improve this document**

If you consider that there is some information that is not clear, missing or needs more clarification please contact us and we will add it to this document as soon as possible. We can improve this document with all of your cooperation.

Thank you very much to help us all to make a better code
