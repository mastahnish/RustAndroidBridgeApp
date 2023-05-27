# RustAndroidBridgeApp

This repository serves an example Android project that uses Rust base library via JNI.

Use this repository to understand how to stucture Android project that is bridged with Rust code.

# How to use it

1. Install https://github.com/casey/just
2. Run `just environment` code in `RustAndroidBridgeApp/android/` directory
3. In order to build `.so` library artifacts run `just build` in `RustAndroidBridgeApp/rust/` directory.
4. Install app.

# What's next

Based on this project you can plan your own usage of Rust lanuage in Android project.
Make sure to get familiar with Rust via official documentation:
https://doc.rust-lang.org/book
https://doc.rust-lang.org/reference

If you want to learn Rust and go deeper with it's usage, take a look at this course from Google where you can find examples for AIDL servers and AOSP features written in Rust.
https://google.github.io/comprehensive-rust/

Happy Learning! 🦀
