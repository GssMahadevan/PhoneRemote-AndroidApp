# PhoneRemote-AndroidApp
Android Appliction to Control the IR based devices via WiFi

### Pre Requisitives
 * Install JDK8. Set JDK8's java in PATH
 * Install latest Android SDK
 * Ensure connect a Androi Smartphone (with > 4.x & Developement options turned on) via USB and device has proper permissions
 
 
 
### Build
 * Build using command
 
 ```
 ./gradlew installDebug
 ```
 
### Change settings
 * Change the http URL of your [python-remote-server](https://github.com/GssMahadevan/PhoneRemote-Server) in settings page of Android-App named as 'TvRemote'
 
## Dependent Projects
 * [PhoneRemote-Server](https://github.com/GssMahadevan/PhoneRemote-Server)
 * [PhoneRemote-ESPIRSender](https://github.com/GssMahadevan/PhoneRemote-ESPIRSender)
 

## UT
 * Test HTTP communications with python server working or not by using curl command like:
 
 ```
curl http://your_python_server_ipurl/ir/change?code=power&model=tv
```

Where 'power' and 'tv' are defined [PhoneRemote-Server/model2file.properties](https://github.com/GssMahadevan/PhoneRemote-Server/blob/master/model2file.properties)


## Add new codes for new TV/IR-Appliance:
 * Follow guide lines as in 
  * [PhoneRemote-Server](https://github.com/GssMahadevan/PhoneRemote-Server)
  * [PhoneRemote-ESPIRSender](https://github.com/GssMahadevan/PhoneRemote-ESPIRSender)

