**!!! DISCLAIMER !!!**: The current code currently wraps the **new launcher**! Management of the old launcher has drastically changed. Version [1.0](https://github.com/ReflxctionDev/MinecraftLauncherLibrary/releases/tag/1.0) has full support
for the old launcher, and 1.0 source code can be found in the [old-launcher](https://github.com/ReflxctionDev/MinecraftLauncherLibrary/tree/old-launcher) branch of this repository tree.

# Minecraft Launcher Library
The most powerful Minecraft Launcher library which gives full access and management to the Minecraft launcher

## Features:

* **Profiles Management**: You can create launcher profiles and remove them, with flexible methods and full control over the profile. (Examples below)
* **Authentication Database**: The launcher by default exposes the logged-in emails, and includes their IGN display name, access/session token, user ID, UUID and e-mail. (Example below)
* **Launcher version**: The launcher also exposes information about the build version. Information exposed includes the launcher build name, the format and the profiles format. (Examples below)
* **Launcher data**: Such as the currently selected user UUID, the currently selected profile and the current client token.
* **Basic launcher features**: This includes fetching Minecraft's working directory. More features will be added to this.
* **Fast and fully documented**

****
# Examples

## Part I: Profiles Management:

#### Creating a custom profile:
```java
LauncherProfile myProfile = new LauncherProfileBuilder()
        .setName("My Profile")
        .setVersionID("1.8.8")
        .setIcon("Base64 encoded image here")
        // More setters are available, though we won't cover all of them
        .build();
```

#### Controlling profiles:
1- Declaring the instance:
```java
// You can initiate your own profile manager as well if you want to provide a custom location for the launcher_version.json.
ProfileManager profileManager = ProfilesManager.getInstance();
```

2- For creating a profile
```java
// Add our own profile
LauncherProfile myProfile = new LauncherProfileBuilder()
        .setName("Boop")
        .setVersionID("1.8.8")
        .build();
profileManager.addProfile(myProfile).save();
// If we're done adding all the profiles we want, you must call:
```

3- For removing a profile
```java
profilesManager.removeProfile("Boop").save();```

**Note**: ProfileManager allows chaining methods. For example, it's possible to do **profileManager.addProfile(profile).removeProfile("Profile to remove").save();**

4- Getting an already existing **LauncherProfile**:
```java
LauncherProfile profile = profilesManager.getProfile("My Profile");
System.out.println("Profile Created At: " + profile.getCreationDate());```

* If you would like to create a modifiable object of this, you can invoke **LauncherProfile#asBuilder()** which would return a **LauncherProfileBuilder**. Do note that changes done in the builder **do not modify the parent profile object**

## Part II: Authentication Database
The launcher by default exposes the auth information such as sessions, access tokens, logged-in and selected emails, etc. You can access those from **LauncherContext**:

#### Accessing the database:
```java
LauncherContext context = MinecraftLauncher.getInstance().getLauncherContext();
Map<String, ProfileAccount> auth = context.getAuthenticationDatabase();
System.out.println(auth.get("4d0faeedcbc319d7268ec15abfdc7a73").getEmail());
```

## Part III: Launcher Version:
The launcher also exposes information about the current launcher build (version). This is perhaps used internally by the launcher to allow compatibility across all launcher versions.

```java
LauncherContext context = MinecraftLauncher.getInstance().getLauncherContext();
LauncherVersion version = context.getLauncherVersion();
System.out.println("Launcher version: " + version.getName());
System.out.println("Format: " + version.getFormat());
System.out.println("Profiles format: " + version.getProfilesFormat());
```

## Part IV: Launcher data:
Little things like the currently selected user and profile are saved inside the launcher data. They can be accessed using this library. They **may not** have a specific section which contains them.

```java
LauncherContext context = MinecraftLauncher.getInstance().getLauncherContext();
System.out.println("Selected Profile: " + context.getSelectedProfile());
System.out.println("Analytics Token: " + context.getAnalyticsToken());
System.out.println("Analytics Fail Count: " + context.getAnalyticsFailCount());```

* **Selected user**:
You can access the selected user as well from the **LauncherContext**. Data is accessible from **ProfileUser**.

```java
ProfileUser selectedUser = context.getSelectedUser();
System.out.println("UUID: " + selectedUser.getProfileUUID());
```
## Part V: Extra features
The library also comes with a few extra features for the launcher. 

* **Accessing Minecraft's working directory (.minecraft)**: This can be accessed through `MinecraftLauncher.WORKING_DIRECTORY` which will return the cached location. This method uses the same exact method the Minecraft launcher uses so it should be at least 97% accurate. If you want the latest working directory, you can get it using `MinecraftLauncher.getExpectedWorkingDirectory()`.
* **Useful Minecraft constants**: Such as `FILE_NAME`, `WORKING_DIRECTORY`, `DATA_FILE`, `GSON`, etc.
