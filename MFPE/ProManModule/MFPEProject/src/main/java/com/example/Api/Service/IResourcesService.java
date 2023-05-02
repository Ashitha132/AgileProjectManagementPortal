package com.example.Api.Service;

import java.util.List;

import com.example.Api.Model.Resources;

public interface IResourcesService {
String AddResource(Resources resources) throws Exception;
List<Resources> getAllResources();
}
