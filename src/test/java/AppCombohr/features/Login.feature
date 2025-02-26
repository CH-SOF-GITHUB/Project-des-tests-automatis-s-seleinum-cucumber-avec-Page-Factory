Feature: Tester la fonctionnalité de connexion sur la plateforme RH Combo

  Scenario Outline: Tester la connexion sur combo avec des données valides et invalides
    Given je suis sur la page de connexion de combo
    When je saisie adresse email <email>
    And je saisie mot de passe <password>
    And je clique sur le bouton Se connecter
    Then connexion avec succès et redirection vers le tableau du board

    Examples:
      | email                  | password          |
      | "bchaker28@yahoo.com"  | "bH3-t58hdwD5AjM" |
      | "bchaker288@yahoo.com" | "bH3-t58hdwD5AjM" |
      | "bchaker28@yahoo.com"  | "bH3-t58hdwD"     |
      | "bchaker@yahoo.com"    | "bH3-t58h!!D"     |
      | "bchaker28@yahoo.com"  | ""                |
      | "bchaker28yahoo.com"   | ""                |
      | ""                     | "bH3-t58hdwD5AjM" |
      | ""                     | "bH3-t58hdwD5AjM" |
      | ""                     | ""                |




