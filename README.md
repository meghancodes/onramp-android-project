![alt_text](https://s2-cdn.greenhouse.io/external_greenhouse_job_boards/logos/400/173/100/resized/Onramp_final_logo_for_twitter___instagram.jpg?1548972880 "image_tooltip")

# Onramp Android Take Home Project 

## Overview 🤖

Furry Angel Finder is an Android application that makes searching for adoptable pets easy. Thanks to its simple UI, users can set search filters and view details about the furry angels matching their search criteria.

In addition, the application provides a downloadable link to a Pet Promise Certification, the perfect gift for a loved one on the hunt for a new pet.

## Description and Details 🔎

Furry Angel Finder is comprised of three activities, one fragment, one service and various UI components, including Buttons, Cards, a List, a Divider and a Snackbar. The application is built in accordance with the MVVM architectural pattern.

#### Architectural Overview

The three app Activities are MainActivity, SearchResultsActivity and PetDetailActivity. The Service is DownloadFileService.

MainActivity
 
MainActivity displays the initial UI for the app. It collects user search parameters and receives search results. Upon receiving the results, it passes them in an Intent which starts SearchResultsActivity.

SearchResultsActivity

SearchResultsActivity displays a list of search results. If the user clicks on one of the results items, an intent is passed to start PetDetailActivity along with pet data that will be shown on the new Activity.

PetDetailActivity

PetDetailActivity displays details about the selected pet. Details include the pet's image, name, gender, breed, size, age and a long description. PetDetailActivity also displays a button, which when pressed, executes the methods necessary to start the application's service.

DownloadFileService

DownloadFileService downloads a file from the internet using a URL.

#### Design Patterns

The application's design adheres to the MVVM (Model, View, ViewModel) architectural pattern. In this pattern, the Model contains the application data, state and business logic. It is not directly connected to the View or ViewModel. The View contains everything related to the UI, including Activities and Fragments. It receives UI-relevant updates by binding to observable variables and actions in the ViewModel. Finally, the ViewModel provides a way for the View to communicate events to the Model, while also preparing observable data for the View. The ViewModel does not contain any reference of the View.

In the app, the View consists of MainActivity, SearchResultsActivity and PetDetailActivity - three Activities, along with a fragment and adapter class. The ViewModel consists of two classes. The Model consists of one service - DownloadFileService, and a handful of classes. When the app first runs, MainActivity executes. It sends the user's pet selection criteria to the ViewModel via a method. The ViewModel passes that data to the Model. The Model then loads and parses a JSON file based on the search data. Since the Model is not tied to the ViewModel, it instantiates a MutableLiveData observer object, and sets its value to the result of the query.  
The ViewModel observes this update, receives the result and updates its own LiveData observer object. The View observes this object and passes it along with an Intent to start the second Activity, SearchResultsActivity.

In this activity, the search results object is carefully processed and made visible to the user in the form of a RecyclerView list on a Fragment. If a user clicks on one of the resulting pets, an Intent is passed to the third Activity, PetDetailActivity. In this activity, if the user clicks on the "Give A Pet Promise" Button, the Button's onClick method is connected to a method in the ViewModel which instantiates a class in the Model which starts a Service.
This Service, DownloadFileService, downloads a Pet Promise Certificate from the internet to the user's phone.     

This structure makes the app reusable. Since the Model, View and ViewModel are separate from each other, the developer can easily pass UI events from the View to the ViewModel to the Model, add necessary business logic to the Model, and create observer variables to communicate the data and make UI updates.   

#### Overall User Flow

Upon running the app, MainActivity is the first component to execute. Within this activity, the app's initial user interface is built.

The user can click on each of the four dropdown arrows to select filters for pet type, gender, size and age. After specifying filters, the user can click on the "Search" Button to begin the search.

If there are no pets matching the search query, a Snackbar is displayed notifying the user and prompting for different search parameters.

If there are pets matching the search query, the application navigates to SearchResultsActivity. This Activity contains a Fragment which displays a vertical RecyclerView list of pet results. Each item in the list is displayed on a Card for improved clarity.

Here, the user can click on a list item to view more details about a specific furry angel of interest. 

Details include the pet's image, name, gender, breed, size, age and a long description.

If the user clicks on the "Give A Pet Promise" Button, a Pet Promise Certificate file will be downloaded to their phone for them to fill out and give to someone.


