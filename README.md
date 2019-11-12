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

The latest version is **1.1.3**. Checkout [here](https://github.com/wooooooak/KcSimpleAlertView/releases)

## Usage

#### Attribute name definition

![image](https://user-images.githubusercontent.com/18481078/62819713-efd7e180-bb93-11e9-81f6-4b69365b5c83.png)

#### SimpleAlertView (kotlin dsl)

**In your activity or fragment**

```kotlin
val simpleAlertView = SimpleAlertView(activity) {
    title {
        text = "Title!"
        textSize = resources.getDimension(R.dimen.sample_text_size)
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
        textSize = resources.getDimension(R.dimen.sample_text_size)
        fontFamily = ResourcesCompat.getFont(context, R.font.your_font)
    }
}
...

simpleAlertView.show()
```

## Customizable

#### Title

| attribute     | type     |
| :------------ | :------- |
| text          | String   |
| textColor     | Int      |
| textSize      | Float    |
| fontFamily    | Typeface |
| paddingLeft   | Int      |
| paddingRight  | Int      |
| paddingTop    | Int      |
| paddingBottom | Int      |

#### Message

Same as title

#### CustomLayout

| attribute    | type |
| :----------- | :--- |
| customLayout | View |

#### Button

| attribute       | type                  |
| :-------------- | :-------------------- |
| text            | String                |
| textColor       | Int                   |
| textSize        | Float                 |
| fontFamily      | Typeface              |
| backgroundColor | Int                   |
| paddingLeft     | Int                   |
| paddingRight    | Int                   |
| paddingTop      | Int                   |
| paddingBottom   | Int                   |
| onClick         | () -> Unit [function] |

**You can add several buttons. But It will be added only horizontal.**

## Theme

| theme           | description              |
| --------------- | ------------------------ |
| WHITE_BORDER    | rectangle with border    |
| WHITE_RECTANGLE | rectangle with no border |

#### Usage

```kotlin
simpleAlertView.setStyleTheme(AlertStyle.WHITE_RECTANGLE)
or
simpleAlertView.setStyleTheme(AlertStyle.WHITE_BORDER)
```

If you have any idea about theme, plz contribute to this progject.

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
