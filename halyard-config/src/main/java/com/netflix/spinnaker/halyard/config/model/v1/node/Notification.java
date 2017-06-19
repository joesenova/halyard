/*
 * Copyright 2017 Johan Kasselman.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.halyard.config.model.v1.node;

//import com.netflix.spinnaker.halyard.config.model.v1.node.Validator;
//import com.netflix.spinnaker.halyard.config.problem.v1.ConfigProblemSetBuilder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Data
@EqualsAndHashCode(callSuper = false)
public abstract class Notification extends Node implements Cloneable {
    boolean enabled = false;

    @Override
    public String getNodeName() {
      return notificationType().getName();
    }

    @Override
    public NodeIterator getChildren() {
      return NodeIteratorFactory.makeEmptyIterator();
    }

    abstract public NotificationType notificationType();

    public enum NotificationType {
        SLACK("slack"),
        EMAIL("email"),
        SMS("sms"),
        HIPCHAT("hipchat");

        @Getter
        String name;

        @Getter
        String id;

        NotificationType(String name) {
            this.name = name;
            this.id = name;
        }
    }

//    @Override
//    public void accept(ConfigProblemSetBuilder psBuilder, Validator v) {
//        v.validate(psBuilder, this);
//    }
}
