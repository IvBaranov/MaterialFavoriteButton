Material Favorite Button
===============

Material spinning favorite/star button

![Demo Image][1]

Gradle
-------------------------

```groovy
  allprojects {
        repositories { 
            jcenter()
            maven { url "https://jitpack.io" }
        }
   }
   dependencies {
        compile 'com.github.ivbaranov:material-favorite-button:0.1.0'
   }
```


Usage
-----

Declare in XML (see xml attributes below for customization):

```xml
<com.github.ivbaranov.mfb.MaterialFavoriteButton
    android:layout_width="wrap_content"
    android:layout_height="wrap_content" />
```

Or static initializer (see xml attributes below for customization):

```java
MaterialFavoriteButton favorite = new MaterialFavoriteButton.Builder(this)
        .create();
```



Configure using xml attributes or setters in code:

```java
app:mfb_animated="true"              			// default state
app:mfb_padding="12"             	 			// image padding
app:mfb_favorite_image="@drawable/ic_fav"       // custom favorite resource
app:mfb_not_favorite_image="drawable/ic_not_fav"// custom not favorite resource
app:mfb_rotation_duration="400"                 // rotation duration
app:mfb_rotation_angle="360"   				    // rotation angle
app:mfb_bounce_duration="300"            		// bounce duration
app:mfb_color="black"              				// black or white default resources
app:mfb_type="star"           					// star or heart shapes
```
Make sure you are using either (`mfb_favorite_image` and `mfb_not_favorite_image`) or (`mfb_color` and `mfb_type`).

Set an `OnFavoriteChangeListener` to `MaterialFavoriteButton`:

```java
favorite.setOnFavoriteChangeListener(
        new MaterialFavoriteButton.OnFavoriteChangeListener() {
          @Override
          public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
          	//
          }
        });
```

Set an `OnFavoriteAnimationEndListener` to `MaterialFavoriteButton`:

```java
favorite.setOnFavoriteAnimationEndListener(
        new MaterialFavoriteButton.OnFavoriteAnimationEndListener() {
          @Override
          public void onAnimationEnd(MaterialFavoriteButton buttonView, boolean favorite) {
            //
          }
        });
```


Developed By
--------------------
Ivan Baranov

License
-----------

```
Copyright 2015 Ivan Baranov

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[1]: https://raw.github.com/ivbaranov/material-favorite/master/images/demo.gif
