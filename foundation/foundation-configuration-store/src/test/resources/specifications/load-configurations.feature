@config-loader
Feature: Load configurations at specified URI based on environment context

  Scenario: The Configuration Service loads configurations into an empty config store
    Given a base URI indicating a directory housing valid base configurations 
    And an environment-specific URI indicating a directory housing valid environment-specific configurations
    When the configuration service starts
    Then the configurations are loaded into the configuration store
    And the user is notified that the configurations were loaded successfully
    And the configuration service records the that the given configurations were loaded successfully

  Scenario: the Configuration Service skips loading already fully loaded properties
    Given a base URI indicating a directory housing valid base configurations 
    And an environment-specific URI indicating a directory housing valid environment-specific configurations
    And the configuration store has been fully populated with the specified configurations
    When the configuration service starts
    Then the configuration service skips the loading process
    And notifies the user that the configurations were previously loaded

  Scenario: The properties are not distinguishable
    Given URIs pointing to nondistinct configurations
    When the configurations are loaded
    Then an exception is thrown stating configurations are not distinguishable

  @config-service
  Scenario: configuration service returns the configuration value
      Given the configuration service has started
       When requests a configuration property
       Then the property value is returned

#  Scenario: The ConfigLoader loads base and environment policies successfully
#    Given URIs pointing to valid base and environment policies
#    When ConfigLoader loads any policies
#    Then the ConfigLoader consumes the base and environment policies
#    And the environment policy overrides the base policy
#
#  Scenario: The ConfigLoader creates rule metadata for each rule in each policy
#    Given URIs pointing to valid base and environment policies
#    And the policies are loaded, reconciled, and validated
#    When the ConfigLoader initializes each policy
#    Then rule metadata is created for each rule
#
#  Scenario: The policy is misformatted
#    Given a URI pointing to a misformatted policy
#    When ConfigLoader loads any policies
#    Then an exception is thrown stating policies are misformatted
#
#  Scenario: The policies are not distinguishable
#    Given URIs pointing to nondistinct policies
#    When ConfigLoader loads any policies
#    Then an exception is thrown stating policies are not distinguishable
#
#  Scenario: A policy has a undefined target property
#    Given a URI pointing to a policy with undefined targets
#    When ConfigLoader loads any policies
#    Then an exception is thrown stating a target property is undefined
#
#  Scenario: A property has multiple policies
#    Given URIs pointing to policies targeting the same property
#    When ConfigLoader loads any policies
#    Then an exception is thrown stating a property cannot be targeted by multiple policies
#
#  Scenario: A policy has a rule implementation class could not be found
#    Given a URI pointing to a policy with a undefined rule implementation class
#    When the policies are loaded
#    Then an exception is thrown stating a rule implementation class could not be found