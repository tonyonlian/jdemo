// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user_info.proto

package com.tongyl.example.jdemosb.entity.protoentity;

public final class UserInfo {
  private UserInfo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_user_info_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_user_info_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017user_info.proto\"A\n\tuser_info\022\n\n\002id\030\001 \001" +
      "(\003\022\014\n\004name\030\002 \001(\t\022\013\n\003age\030\003 \001(\005\022\r\n\005money\030\004" +
      " \001(\001B;\n-com.tongyl.example.jdemosb.entit" +
      "y.protoentityB\010UserInfoP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_user_info_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_user_info_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_user_info_descriptor,
        new java.lang.String[] { "Id", "Name", "Age", "Money", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}