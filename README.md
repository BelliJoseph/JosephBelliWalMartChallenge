# WalMart Challenge

## Design
This project uses the MVVM + clean architecture using a repository layer for more abstraction. 
This project uses the recyclerView component to display the list of movies. 
The builder pattern was used to create Gson, OkHttp, and Retrofit.

![image](https://github.com/user-attachments/assets/c3dd271b-2a81-4370-99b4-ce23a58b4889)

## Libraries
OkHttp, LoggingInterceptor, and Retrofit were used for network calls for ease of use and reliability.
```
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.okhttp3:okhttp:5.0.0-alpha.2'
implementation 'com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2'
```

Gson was used for converting JSON to Kotlin data class objects.
Gson was used for it's speed of converting and ease of use.
```
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'
implementation 'com.google.code.gson:gson:2.9.0'
```

Coroutines was used for long running tasks for network calls.
