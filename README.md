# Image Manipulation and Ascii Generation
> Many tools for manipulating images and generating ascii images and texts.

### Image to grayscale
<img src="https://user-images.githubusercontent.com/47650058/181915471-ea54debd-c62b-4d53-b702-1e084674e77a.jpg" alt="normal killua" width="150"> <img src="https://user-images.githubusercontent.com/47650058/181915303-cc693e76-0f2d-4835-be0c-d9faca6de086.png" alt="gray killua" width="150">

- Converts the provided image to grayscale

#### Converting to Grayscale Image
1. Iterate through every pixel in the image.
2. At each pixel, calculate the RGB values.
3. Normalize the RGB values and gamma correct.
4. Calculate the luminance of the pixel.
5. Gamma compand and rescale the the final RGB values into byte range.
6. Update the pixel's color.

### Image to Ascii
<img src="https://user-images.githubusercontent.com/47650058/181915471-ea54debd-c62b-4d53-b702-1e084674e77a.jpg" alt="normal killua" width="150"> <img src="https://user-images.githubusercontent.com/47650058/181915533-11d0c1fe-7329-49e2-a4c1-9a099d4c05f5.png" alt="ascii killua" width="150">


1. Asks for desired ascii image resolution (width in characters) (the higher the better)
2. Converts the provided image to grayscale
3. Converts the grayscale image to ascii text according to the given resolution (using a linearly distrubted intensity character map)

*This can be used for profiles or even Neovim Dashboards*

#### Converting to Ascii Text
1. Iterate through every x pixels in the grayscale image according to the desired resolution.
2. Calculate the intensity of the pixel by calculating the intensity of each RGB value in selected pixel (on a scale of `0 - (length(intensityMap)-1))` and then averaging between the 3 values.
3. Based on the calculated intensity of the pixel, select an ascii character from the intensity map and append it to the final resulting ascii image.

### Text to Ascii

```
 _  __ _  _     _     _     ____ 
/ |/ // \/ \   / \   / \ /\/  _ \
|   / | || |   | |   | | ||| / \|
|   \ | || |_/\| |_/\| \_/|| |-||
\_|\_\\_/\____/\____/\____/\_/ \|
```

- Converts the provided text into ascii characters (purely for aesthetic looks)

*This only works for alphabetical letters and no other characters* <br>
*This can be used for Neovim Dashboards*

1. Iterate through the levels of the ascii map (from top to bottom)
2. Iterate through the characters of the provided text
3. Select the String at the position of that alphabet in the asciiMap and append it to the resulting ascii text.
