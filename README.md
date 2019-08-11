# KcSimpleAlertView

## Sample image

![image](https://user-images.githubusercontent.com/18481078/62819785-164a4c80-bb95-11e9-9fda-f293a4578780.png)

## Install

### Gradle

**1. Add the JitPack repository to your project level build.gradle file**

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

**2. Add the dependency to your app level build.gradle file**

```groovy
dependencies {
    implementation 'com.github.wooooooak:kcsimplealertview:$version'
}
```

The latest version is **1.0.2**. Checkout [here](https://github.com/wooooooak/KcSimpleAlertView/releases)

## Usage

#### Attribute name definition

![image](https://user-images.githubusercontent.com/18481078/62819713-efd7e180-bb93-11e9-81f6-4b69365b5c83.png)

#### SimpleAlertView (kotlin dsl)

**In your activity or fragment**

```kotlin
val simpleAlertView = SimpleAlertView(activity) {
    title {
        text = "Title!"
        textSize = 20
    }
    message {
        text = "this is message"
        textColor = ContextCompat.getColor(context, R.color.colorAccent)
    }
    customLayout = LayoutInflater.from(context).inflate(R.layout.custom_layout, null, false)
    button {
        text = "1st button"
        onClick = {
            Toast.makeText(context, "on click 1st button", Toast.LENGTH_SHORT).show()
        }
    }
    button {
        text = "2nd button"
        fontFamily = ResourcesCompat.getFont(context, R.font.your_font)
    }
}
...

simpleAlertView.show()
```

## What you can customizable

#### title

| attribute     | type     |
| :------------ | :------- |
| text          | String   |
| textColor     | Int      |
| textSize      | Int      |
| fontFamily    | Typeface |
| paddingLeft   | Int      |
| paddingRight  | Int      |
| paddingTop    | Int      |
| paddingBottom | Int      |

#### message

Same as title

#### customLayout

| attribute    | type |
| :----------- | :--- |
| customLayout | View |

#### button

| attribute       | type                  |
| :-------------- | :-------------------- |
| text            | String                |
| textColor       | Int                   |
| textSize        | Int                   |
| fontFamily      | Typeface              |
| backgroundColor | Int                   |
| paddingLeft     | Int                   |
| paddingRight    | Int                   |
| paddingTop      | Int                   |
| paddingBottom   | Int                   |
| onClick         | () -> Unit [function] |

**You can add several buttons. But It will be added only horizontal.**

## Contribution

All Pull Request and Issues are welcome!

## License

```
Copyright 2019 wooooooak (Yongjun LEE)

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
