// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user_info.proto

package com.tongyl.example.jdemosb.entity.protoentity;

public interface user_infoOrBuilder extends
    // @@protoc_insertion_point(interface_extends:user_info)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>int32 age = 3;</code>
   * @return The age.
   */
  int getAge();

  /**
   * <code>double money = 4;</code>
   * @return The money.
   */
  double getMoney();
}
