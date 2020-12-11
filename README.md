# Android-Bottom-Navigation

## Original project
-----------------------

 [https://github.com/armcha/Space-Navigation-View](https://github.com/armcha/Space-Navigation-View)

## Improvements 
-----------------------

- Androidx use
- Added draw_bezier_view parameter
- Added setInitalSelectedItem  

## Installation
-----------------------


Gradle:

```groovy
allprojects {
 repositories {
  ...
  maven { url 'https://jitpack.io' }
 }
}
```

```groovy
dependencies {
 implementation 'com.github.KDVL:Android-Bottom-Navigation:1.0.0'
}
```

Maven:

```xml
<repositories>
  <repository>
   <id>jitpack.io</id>
   <url>https://jitpack.io</url>
  </repository>
</repositories>
```


```xml
<dependency>
  <groupId>com.github.KDVL</groupId>
  <artifactId>Android-Bottom-Navigation</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Usage
------------------

Add the Space Navigation view to your layout

```xml
 <FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
     xmlns:tools="http://schemas.android.com/tools"
     xmlns:app="http://schemas.android.com/apk/res-auto"
     android:layout_width="match_parent"
     android:layout_height="match_parent">
     
      <...View
             ....
             android:layout_marginBottom="@dimen/view_bottom_margin" />
             
      <ch.kdvl.bottomNavigation.SpaceNavigationView
             android:id="@+id/nav_view"
             android:layout_width="match_parent"
             android:layout_height="match_parent"
             android:layout_gravity="bottom"/>
             
 </FrameLayout>
```

Add Space Navigation items.

```java
   SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.nav_view);
   spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
   spaceNavigationView.addSpaceItem(new SpaceItem("HOME", R.drawable.yourDrawable));
   spaceNavigationView.addSpaceItem(new SpaceItem("SEARCH", R.drawable.yourDrawable));
```

Use ```initWithSaveInstanceState(savedInstanceState)``` and override ```onSaveInstanceState``` 
if you want to keep selected item position and badge on device rotation
```java
       @Override
       protected void onSaveInstanceState(Bundle outState) {
           super.onSaveInstanceState(outState);
           spaceNavigationView.onSaveInstanceState(outState);
       }
```

Set onClick listener
```java
   spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
               Toast.makeText(MainActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
               Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
            
             @Override
             public void onItemReselected(int itemIndex, String itemName) {
               Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();           
            }
        });
```

Set onLongClick listener
```java
    spaceNavigationView.setSpaceOnLongClickListener(new SpaceOnLongClickListener() {
            @Override
            public void onCentreButtonLongClick() {
                Toast.makeText(MainActivity.this,"onCentreButtonLongClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });
```

Customize
---------

Customize with xml

```xml
 <ch.kdvl.bottomNavigation.SpaceNavigationView
        android:id="@+id/nav_view"
        app:active_item_color="@color/white"
        app:inactive_item_color="@color/inactive_tab"
        app:active_centre_button_icon_color="@color/white"
        app:inactive_centre_button_icon_color="@color/inactive_tab"
        app:centre_button_color="@color/middle_button"
        app:active_centre_button_background_color="@color/middle_button"
        app:space_background_color="@color/custom_red"
        app:centre_button_icon="@drawable/ic_tab_home"
        app:draw_bezier_view="true"
        app:space_item_icon_size="@dimen/space_item_icon_only_size"
        app:space_item_icon_only_size="@dimen/space_item_icon_only_size" />
```

|  Attribute | Description |
|---|---|
| active_item_color  | item color when selected |
| inactive_item_color |  item color when unselected |
| centre_button_color | centre circle button color |
| space_background_color | space view background color |
| space_item_icon_size | item icon size |
| space_item_icon_only_size | item icon size on ```showIconOnly()``` mode |
| space_item_text_size | item text size |
| centre_button_icon | allow changing center icon from layout |
| draw_bezier_view | if true (default) draw the bezier view around rounded button |
 
draw_bezier_view is true /   draw_bezier_view is false

![](examples/draw_bezier_view.png)

Change space navigation background
```java
spaceNavigationView.setSpaceBackgroundColor(ContextCompat.getColor(this, R.color.yourColor));
```

Change centre button icon 
```java
spaceNavigationView.setCentreButtonIcon(R.drawable.yourDrawable);
```

Change centre button background color 
```java
spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.yourColor));
```

Change selected item text and icon color
```java
spaceNavigationView.setActiveSpaceItemColor(ContextCompat.getColor(this, R.color.yourColor));
```

Change unselected item text and icon color
```java
spaceNavigationView.setInActiveSpaceItemColor(ContextCompat.getColor(this, R.color.yourColor));
```

Change space item icon size
```java
spaceNavigationView.setSpaceItemIconSize((int) getResources().getDimension(R.dimen.yourDimen));
```

Change space item icon size when ```showIconOnly();``` mode activated
```java
spaceNavigationView.setSpaceItemIconSizeInOnlyIconMode((int) getResources().getDimension(R.dimen.yourDimen));
```

Change space item text size
```java
spaceNavigationView.setSpaceItemTextSize((int) getResources().getDimension(R.dimen.yourDimen));
```

Change initial selected item
```java
spaceNavigationView.setInitalSelectedItem(-1);
```

Hide items text and show only icons
```java
spaceNavigationView.showIconOnly();
```
![](screens/screen2.png)

Hide items icon and show only texts
```java
spaceNavigationView.showTextOnly();
```
![](screens/screen5.png)

You can change selected item programmatically
```java
spaceNavigationView.changeCurrentItem(int tabIndexToSelect);
```

Show badge
```java
spaceNavigationView.showBadgeAtIndex(int itemIndexToShowBadge, int badgeCountText, int badgeBackgroundColor);
```
![](screens/gif1.gif)

Hide badge at index
```java
spaceNavigationView.hideBadgeAtIndex(int itemIndexToHideBadge);
```
![](screens/gif2.gif)

Hide all badges
```java
spaceNavigationView.hideAllBadges();
```

Change badge text
```java
spaceNavigationView.changeBadgeTextAtIndex(int itemIndexToChangeBadge, int badgeCountText);
```

Set your custom font
```java
spaceNavigationView.setFont(Typeface.createFromAsset(getAssets(), "your_cutom_font.ttf"));
```

Set centre button pressed state color
```java
spaceNavigationView.setCentreButtonRippleColor(ContextCompat.getColor(this, R.color.yourColor));
```

Now you can change centre button icon if space navigation view already set up
```java
spaceNavigationView.changeCenterButtonIcon(R.drawable.yourDrawable);
```

Also you can change item text and icon  if space navigation view already set up
```java
spaceNavigationView.changeItemTextAtPosition(0, "NEW TEXT");
spaceNavigationView.changeItemIconAtPosition(1, R.drawable.yourDrawable);
```

Now you can change space navigation view background color if it already set up
```java
 spaceNavigationView.changeSpaceBackgroundColor(ContextCompat.getColor(context,R.color.yourColor));
```
![](screens/gif3.gif)

If you want to show full badge text or show 9+
```java
spaceNavigationView.shouldShowFullBadgeText(true);
```

Set centre button icon color
```java
spaceNavigationView.setCentreButtonIconColor(ContextCompat.getColor(context,R.color.yourColor));
```
If you want to disable default white color filter, just call
```java
spaceNavigationView.setCentreButtonIconColorFilterEnabled(false);
```




