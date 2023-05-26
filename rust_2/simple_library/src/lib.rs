extern crate jni;

use jni::JNIEnv;
use jni::objects::{JClass};
use jni::sys::{jint};

// A simple function that adds two integers.
fn add_two_ints(a: i32, b: i32) -> i32 {
    a + b
}

// This is a JNI bridge function.
// The `#[no_mangle]` attribute tells Rust not to mangle the function name.
// The `pub extern "system"` part makes the function adhere to the C calling convention,
// as required by JNI.
#[no_mangle]
pub extern "system" fn Java_pl_myosolutions_rustandroidbridgeapp_MainActivity_addTwoInts(
    _env: JNIEnv,
    _class: JClass,
    a: jint,
    b: jint
) -> jint {
    // Call our Rust function and return the result.
    add_two_ints(a as i32, b as i32) as jint
}
