// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SearchService.proto

package com.trace.trace.grpc;

public final class SearchServiceOuterClass {
  private SearchServiceOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_trace_trace_grpc_QueryRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_trace_trace_grpc_QueryRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_trace_trace_grpc_CompetRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_trace_trace_grpc_CompetRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_trace_trace_grpc_GraphRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_trace_trace_grpc_GraphRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_trace_trace_grpc_QueryResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_trace_trace_grpc_QueryResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_trace_trace_grpc_TraceResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_trace_trace_grpc_TraceResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_trace_trace_grpc_GraphResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_trace_trace_grpc_GraphResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023SearchService.proto\022\024com.trace.trace.g" +
      "rpc\">\n\014QueryRequest\022\021\n\tqueryType\030\001 \001(\t\022\r" +
      "\n\005query\030\002 \001(\t\022\014\n\004page\030\003 \001(\t\"!\n\rCompetReq" +
      "uest\022\020\n\010regis_id\030\001 \001(\t\"\034\n\014GraphRequest\022\014" +
      "\n\004kind\030\001 \001(\t\"!\n\rQueryResponse\022\020\n\010respons" +
      "e\030\001 \001(\t\"8\n\rTraceResponse\022\020\n\010response\030\001 \001" +
      "(\t\022\025\n\rresponseMedia\030\002 \001(\014\"!\n\rGraphRespon" +
      "se\022\020\n\010response\030\001 \001(\t2\361\002\n\rSearchService\022V" +
      "\n\013searchQuery\022\".com.trace.trace.grpc.Que" +
      "ryRequest\032#.com.trace.trace.grpc.QueryRe" +
      "sponse\022X\n\014searchCompet\022#.com.trace.trace" +
      ".grpc.CompetRequest\032#.com.trace.trace.gr" +
      "pc.QueryResponse\022V\n\013searchTrace\022\".com.tr" +
      "ace.trace.grpc.QueryRequest\032#.com.trace." +
      "trace.grpc.TraceResponse\022V\n\013searchGraph\022" +
      "\".com.trace.trace.grpc.GraphRequest\032#.co" +
      "m.trace.trace.grpc.GraphResponseB\002P\001b\006pr" +
      "oto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_com_trace_trace_grpc_QueryRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_trace_trace_grpc_QueryRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_trace_trace_grpc_QueryRequest_descriptor,
        new java.lang.String[] { "QueryType", "Query", "Page", });
    internal_static_com_trace_trace_grpc_CompetRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_trace_trace_grpc_CompetRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_trace_trace_grpc_CompetRequest_descriptor,
        new java.lang.String[] { "RegisId", });
    internal_static_com_trace_trace_grpc_GraphRequest_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_trace_trace_grpc_GraphRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_trace_trace_grpc_GraphRequest_descriptor,
        new java.lang.String[] { "Kind", });
    internal_static_com_trace_trace_grpc_QueryResponse_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_com_trace_trace_grpc_QueryResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_trace_trace_grpc_QueryResponse_descriptor,
        new java.lang.String[] { "Response", });
    internal_static_com_trace_trace_grpc_TraceResponse_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_com_trace_trace_grpc_TraceResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_trace_trace_grpc_TraceResponse_descriptor,
        new java.lang.String[] { "Response", "ResponseMedia", });
    internal_static_com_trace_trace_grpc_GraphResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_com_trace_trace_grpc_GraphResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_trace_trace_grpc_GraphResponse_descriptor,
        new java.lang.String[] { "Response", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}