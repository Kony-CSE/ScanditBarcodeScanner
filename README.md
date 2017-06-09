# ScanditBarcodeScanner
ScanditBarcodeScanner in 6.5 and 7.2.1 Kony Studio

Steps for AAR Integration in Kony Studio 7.2.1

***Step 1***
Generate an AAR file which works independently.
While generating the AAR file from Android Studio please check the below things.

applicationId in build.gradle is commented.
android:icon attribute is removed in Manifest
android:name attribute is removed in manifest before generating AAR.
Comment Intent filters in Android Manifest.
Eg: <intent-filter>
	<action android:name="android.intent.action.MAIN" />
	<category android:name="android.intent.category.LAUNCHER" />
	</intent-filter>

***Step 2***
Create a Java project in Eclipse
Add Android.jar, KonyWidgets.jar and classes.jar
Classes.jar will be available in the AAR file. Open Archive the AAR and copy the Classes.jar
Write a java class in a Static method to invoke an activity in the AAR file.

***Step3***
Using the jar exported in Step 2 do the FFI integrations.
Copy the AAR under Customlibs/andriod folder


In case if there are few more dependencies to be added in build.gralde. Do use a precompile task to achieve this.

Steps for AAR Integration in Kony Studio 6.5

Do follow the above steps and later below is the additional step to be done for Kony Studio 6.5

***Step 4***
Do modify the build.xml under gradleSetup folder. Modify the gradle path.
Download the gradle from the below path.
https://services.gradle.org/distributions/gradle-2.14.1-bin.zip

Note: Make sure package names are different in all the 3 steps mentioned above. Until and unless it is requires ***android:name*** for your application.
