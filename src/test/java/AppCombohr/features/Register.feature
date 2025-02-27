Feature: Tester la fonctionnalité inscription sur la plateforme RH Combo

  Scenario Outline: tester la création de compte avec des valides et invalides
    Given je suis sur la page de connexion combo
    When je clique sur le bouton Créer un compte
    And je saisie nom de votre entreprise <nomentrperise>
    And je saisie prénom <prenom>
    And je saisie nom <nom>
    And je saisie téléphone <telephone>
    And je saisie email <email>
    And je saisie password <password>
    And je saisie confirm_password <confirm_password>
    And je clique sur le bouton Suivant
    Then redirection vers la page suivante d'inscription
    And je clique sur un nombre d'établissements "2-5"
    And je clique sur un nombre d'employés "11-15"
    And je sélectionne intitulé de poste "Manager"
    And je sélectionner secteur d'activité "Restauration traditionnelle"
    And je clique sur je suis franchisé
    And je sélectionner un pays "Italie"
    And je clique sur un bouton Créer un compte
    Then création de compte avec succès
    Examples:
      | nomentrperise   | prenom   | nom        | telephone    | email                    | password     | confirm_password |
      # cas idéal données valides
      | "Altran france" | "Chaker" | "Ben Said" | "0601234578" | "chaker.bensaid@yahoo.com" | "Azerty123!" | "Azerty123!"     |