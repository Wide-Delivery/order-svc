// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: rpc_create_order.proto

// Protobuf Java Version: 3.25.1
package com.widedelivery.order.proto;

public interface CreateOrderInputOrBuilder extends
    // @@protoc_insertion_point(interface_extends:order.CreateOrderInput)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>.order.UserDTO user = 1;</code>
   * @return Whether the user field is set.
   */
  boolean hasUser();
  /**
   * <code>.order.UserDTO user = 1;</code>
   * @return The user.
   */
  UserDTO getUser();
  /**
   * <code>.order.UserDTO user = 1;</code>
   */
  UserDTOOrBuilder getUserOrBuilder();

  /**
   * <code>string cargo_type = 2;</code>
   * @return The cargoType.
   */
  String getCargoType();
  /**
   * <code>string cargo_type = 2;</code>
   * @return The bytes for cargoType.
   */
  com.google.protobuf.ByteString
      getCargoTypeBytes();

  /**
   * <code>double cargo_length = 3;</code>
   * @return The cargoLength.
   */
  double getCargoLength();

  /**
   * <code>double cargo_width = 4;</code>
   * @return The cargoWidth.
   */
  double getCargoWidth();

  /**
   * <code>double cargo_height = 5;</code>
   * @return The cargoHeight.
   */
  double getCargoHeight();

  /**
   * <code>double cargo_weight = 6;</code>
   * @return The cargoWeight.
   */
  double getCargoWeight();

  /**
   * <code>string departure_longitude = 7;</code>
   * @return The departureLongitude.
   */
  String getDepartureLongitude();
  /**
   * <code>string departure_longitude = 7;</code>
   * @return The bytes for departureLongitude.
   */
  com.google.protobuf.ByteString
      getDepartureLongitudeBytes();

  /**
   * <code>string departure_latitude = 8;</code>
   * @return The departureLatitude.
   */
  String getDepartureLatitude();
  /**
   * <code>string departure_latitude = 8;</code>
   * @return The bytes for departureLatitude.
   */
  com.google.protobuf.ByteString
      getDepartureLatitudeBytes();

  /**
   * <code>.google.protobuf.Timestamp departure_time = 9;</code>
   * @return Whether the departureTime field is set.
   */
  boolean hasDepartureTime();
  /**
   * <code>.google.protobuf.Timestamp departure_time = 9;</code>
   * @return The departureTime.
   */
  com.google.protobuf.Timestamp getDepartureTime();
  /**
   * <code>.google.protobuf.Timestamp departure_time = 9;</code>
   */
  com.google.protobuf.TimestampOrBuilder getDepartureTimeOrBuilder();

  /**
   * <code>string destination_longitude = 10;</code>
   * @return The destinationLongitude.
   */
  String getDestinationLongitude();
  /**
   * <code>string destination_longitude = 10;</code>
   * @return The bytes for destinationLongitude.
   */
  com.google.protobuf.ByteString
      getDestinationLongitudeBytes();

  /**
   * <code>string destination_latitude = 11;</code>
   * @return The destinationLatitude.
   */
  String getDestinationLatitude();
  /**
   * <code>string destination_latitude = 11;</code>
   * @return The bytes for destinationLatitude.
   */
  com.google.protobuf.ByteString
      getDestinationLatitudeBytes();

  /**
   * <code>.google.protobuf.Timestamp destination_time = 12;</code>
   * @return Whether the destinationTime field is set.
   */
  boolean hasDestinationTime();
  /**
   * <code>.google.protobuf.Timestamp destination_time = 12;</code>
   * @return The destinationTime.
   */
  com.google.protobuf.Timestamp getDestinationTime();
  /**
   * <code>.google.protobuf.Timestamp destination_time = 12;</code>
   */
  com.google.protobuf.TimestampOrBuilder getDestinationTimeOrBuilder();

  /**
   * <code>string description = 13;</code>
   * @return The description.
   */
  String getDescription();
  /**
   * <code>string description = 13;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>bool need_loader = 14;</code>
   * @return The needLoader.
   */
  boolean getNeedLoader();

  /**
   * <code>string payment_method = 15;</code>
   * @return The paymentMethod.
   */
  String getPaymentMethod();
  /**
   * <code>string payment_method = 15;</code>
   * @return The bytes for paymentMethod.
   */
  com.google.protobuf.ByteString
      getPaymentMethodBytes();
}
