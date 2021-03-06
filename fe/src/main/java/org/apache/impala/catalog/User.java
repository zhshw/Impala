// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.impala.catalog;

import com.google.common.base.Preconditions;
import org.apache.impala.thrift.TPrincipal;
import org.apache.impala.thrift.TPrincipalType;

import java.util.Set;

/**
 * Represents a role in an authorization policy.
 */
public class User extends Principal {
  public User(String userName, Set<String> grantGroups) {
    super(userName, TPrincipalType.USER, grantGroups);
  }

  public User(TPrincipal thriftPrincipal) {
    super(thriftPrincipal);
    Preconditions.checkArgument(
        thriftPrincipal.getPrincipal_type() == TPrincipalType.USER);
  }

  @Override
  protected boolean isCaseInsensitiveKeys() {
    // If Sentry changes the user name to be case sensitive, make sure to update
    // this code to return false.
    return true;
  }
}
