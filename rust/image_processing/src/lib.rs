/*extern crate image;
extern crate jni;

use jni::JNIEnv;
use jni::objects::{JClass, JByteBuffer};
use jni::sys::{jbyteArray, jint};
use image::{GenericImageView, GenericImage, FilterType, DynamicImage};
use image::imageops::colorops::grayscale;

use std::os::raw::c_void;
use std::slice;

#[no_mangle]
pub extern "system" fn Java_pl_myosolutions_rustandroidbridgeapp_MainActivity_grayscaleFilter(
    env: JNIEnv,
    _class: JClass,
    image_data: JByteBuffer,
    width: jint,
    height: jint
) -> jbyteArray {
    let image_data_ptr = env.get_direct_buffer_address(image_data).unwrap();
    let image_slice = unsafe { slice::from_raw_parts_mut(image_data_ptr as *mut u8, (width * height * 4) as usize) };

    let img = image::ImageBuffer::from_raw(width as u32, height as u32, image_slice.to_vec()).unwrap();
    let gray_img = grayscale(&img);

    let gray_image_data = gray_img.into_raw();

    // Convert gray_image_data back to jbyteArray to return to Java
    let output_image = env.byte_array_from_slice(&gray_image_data).unwrap();

    output_image
}
*/